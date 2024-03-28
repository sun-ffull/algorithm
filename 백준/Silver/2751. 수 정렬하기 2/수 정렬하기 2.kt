import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var size : Int = br.readLine().toInt()
    var arr:Array<Int> = Array<Int>(size){0}

    repeat(size){
        arr[it] = br.readLine().toInt()
    }
    arr.sort()

    repeat(size){
        bw.write(arr[it].toString() + "\n")
    }
    bw.flush()
    bw.close()
    br.close()
}