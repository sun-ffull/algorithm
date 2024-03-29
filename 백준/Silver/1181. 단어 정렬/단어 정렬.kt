import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N : Int = br.readLine().toInt()
    var arr :Array<String> = Array<String>(N) {""}

    repeat(N){
        arr[it] = br.readLine()
    }
    arr = arr.distinct().toTypedArray()

    arr.sortWith(
        compareBy(
            {it.length},
            {it}
        )
    )

    repeat(arr.size){
        bw.write(arr[it] + "\n")
    }
    bw.flush()
    bw.close()
    br.close()
}