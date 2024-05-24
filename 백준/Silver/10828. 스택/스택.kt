import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    var st: StringTokenizer
    var arrlist = arrayListOf<Int>()

    for (i in 1..N){
        st = StringTokenizer(br.readLine(), " ")
        val order = st.nextToken()

        when (order) {
            "push" -> {
                val value = st.nextToken().toInt()
                arrlist.add(0, value)
            }
            "pop" -> {
                val value = arrlist.removeFirstOrNull()
                if (value == null){
                    bw.write("-1\n")
                }
                else {
                    bw.write("$value\n")
                }
            }
            "size" -> {
                val value = arrlist.size
                bw.write("$value\n")
            }
            "empty" -> {
                if (arrlist.size == 0){
                    bw.write("1\n")
                }
                else {
                    bw.write("0\n")
                }
            }
            "top" -> {
                val value = arrlist.getOrNull(0)
                if (value == null){
                    bw.write("-1\n")
                }
                else {
                    bw.write("$value\n")
                }
            }
            else -> println("잘못된 명령어")
        }
    }

    bw.flush()
    bw.close()
}