package utils

class Timer(frames: Int) {
    private var curFrame = 0;
    def ++ : Unit = curFrame += 1

    def resetIf(): Boolean = {
        var out = false
        if(curFrame >= frames)
            out = true
            curFrame = 0
        out
    }
  
}
