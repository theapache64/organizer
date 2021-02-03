import java.io.File
import java.nio.file.Files

private const val IS_DEBUG = false

fun main(args: Array<String>) {

    // If -d passed, it'll also move directories
    val shouldMoveDirs = args.isNotEmpty() && args.first().toLowerCase() == "-d"

    val currentDir = if (IS_DEBUG) {
        File("/home/theapache64/Desktop")
    } else {
        File(System.getProperty("user.dir"))
    }

    currentDir.listFiles()?.let { files ->

        // Looping through all files
        for (file in files) {

            // Finding target directory name
            val targetDir = if (Files.isRegularFile(file.toPath())) {
                val extension = ".${file.extension}"
                FileUtils.getTargetDirName(extension)
            } else {
                if (shouldMoveDirs) {
                    "Directories"
                } else {
                    continue
                }
            }

            // Building target file to move
            val targetFile = File("${file.parent}/$targetDir/${file.name}")
            targetFile.parentFile.mkdirs()
            val isMoved = file.renameTo(targetFile)
            if (isMoved) {
                val relativePath = "${targetFile.parentFile.name}/${targetFile.name}"
                println("➡️ ${file.name} moved to $relativePath")
            } else {
                println("❌ Failed to move ${file.name} to ${targetFile.absolutePath}")
            }

        }
    } ?: println("No file found inside ${currentDir.name}")
}


