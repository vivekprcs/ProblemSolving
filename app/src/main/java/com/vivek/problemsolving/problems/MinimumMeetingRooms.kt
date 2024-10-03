package com.vivek.problemsolving.problems


fun getMinRooms(meetingTimings: Array<IntArray>): Int {
    val noOfMeetings = meetingTimings.size
    val start = IntArray(noOfMeetings)
    val end = IntArray(noOfMeetings)
    for (i in 0 until noOfMeetings) {
        start[i] = meetingTimings[i][0]
        end[i] = meetingTimings[i][1]
    }
    start.sort()
    end.sort()
    var i = 1
    var j = 0
    var curr = 1
    var noOfRooms = 1
    while (i < start.size && j < end.size) {
        if (start[i] < end[j]) {
            curr++
            i++
        } else {
            curr--
            j++
        }
        noOfRooms = Integer.max(noOfRooms, curr)
    }
    return noOfRooms
}

fun main() {

    //Test cases
    val intervals1 = arrayOf(
        intArrayOf(1, 18),
        intArrayOf(18, 23),
        intArrayOf(15, 24),
        intArrayOf(4, 15),
        intArrayOf(2, 11),
        intArrayOf(5, 13)
    )
    println("min rooms required for meetings " + getMinRooms(intervals1))
    val intervals2 = arrayOf(
        intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20)
    )
    println("min rooms required for meetings " + getMinRooms(intervals2))
    val intervals3 = arrayOf(
        intArrayOf(7, 10), intArrayOf(2, 4)
    )
    println("min rooms required for meetings " + getMinRooms(intervals3))

}