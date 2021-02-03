object FileUtils {
    /**
     * To get target directory name from file extension.
     */
    fun getTargetDirName(extension: String): String {
        var targetDirName: String? = null
        for (mapEntry in FILE_MAP.entries) {
            val dirName = mapEntry.key
            if (mapEntry.value.contains(extension.toLowerCase())) {
                targetDirName = dirName
                break
            }
        }

        if (targetDirName == null) {
            targetDirName = "Others"
        }

        return targetDirName
    }
}