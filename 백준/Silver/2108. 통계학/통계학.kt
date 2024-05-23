import java.util.Scanner
import kotlin.math.*

fun main() {
    val scan: Scanner = Scanner(System.`in`)
    val N = scan.nextInt()

    var total = 0.0      //산술평균
    val middle: Int         //중앙값
    var list = mutableListOf<Int>()         //중앙값
    var map = mutableMapOf<Int, Int>()     //최빈값
    var findMap : Int                           //최빈값
    var max = -4000         //범위
    var min = 4000          //범위

    for (i in 1..N){
        val tmp = scan.nextInt()
        total += tmp
        list.add(tmp)

        var mapV = map.get(tmp) ?: 0
        mapV += 1
        map[tmp] = mapV

        if (tmp > max) {
            max = tmp
        }
        if (tmp < min){
            min = tmp
        }
    }

    total = round(total/N)

    list.sort()
    middle = list[N/2]

    var tmp = 0
    var frequencylist = mutableListOf<Int>()
    for ((key, v) in map.entries){
        if (v > tmp){
            findMap = key
            tmp = v
            frequencylist.clear()
            frequencylist.add(key)
        }
        else if (v == tmp){
            frequencylist.add(key)
        }
    }
    if (frequencylist.size > 1){
        frequencylist.sort()
        findMap = frequencylist[1]
    }
    else {
        findMap = frequencylist[0]
    }

    val scope = max - min

    println(total.toInt())
    println(middle)
    println(findMap)
    println(scope)
}