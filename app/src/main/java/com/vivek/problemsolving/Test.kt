
import java.util.*
import kotlin.system.measureTimeMillis

fun main(){
   val list1 = listOf(8, 8, 7, 2, 1, 7, 9,10,12)
   val list2 = listOf(14, 8, 2, 7, 7,13,)
   val result = solve(list1,list2)
    print(result)
}

fun <T> solve(list1:List<T>, list2:List<T>): TreeSet<T> {
    val missingItems = sortedSetOf<T>()
    list2.forEach {
       if(!(list1.contains(it)&&
           getFrequency(it,list2)==getFrequency(it,list1))){
           missingItems.add(it)
       }
    }
    return missingItems
}

fun <T> getFrequency(it: T, list: List<T>) :Int {
 return Collections.frequency(list,it)
}
