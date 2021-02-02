import com.theapache64.expekt.should
import org.junit.Test

class FileUtilsTest {
    @Test
    fun getTargetDirName() {

        // Images
        FileUtils.getTargetDirName(".jpg").should.equal("Images")
        FileUtils.getTargetDirName(".png").should.equal("Images")
        FileUtils.getTargetDirName(".mp4").should.equal("Videos")
        FileUtils.getTargetDirName(".mov").should.equal("Videos")
        FileUtils.getTargetDirName(".fdgdf").should.equal("Others")

    }
}