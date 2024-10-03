package com.vivek.problemsolving.problems

data class Book(val name:String, var qty: Int)
interface NotificationManager{
    fun sendNotification()
}
interface BookManager{
    fun isBookAvailable(book:Book): Boolean
    fun borrowBook(book :Book)
    fun returnBook(book :Book)
    fun getAllBooks(): MutableList<Book>
}

class DatabaseManager{
    var books = mutableListOf<Book>()

    init{
        books = mutableListOf(Book("Meluha",3), Book("Twilight",2), Book("Rama",1))
    }

    fun getallBooks():MutableList<Book>{
        println(books.toString())
        return books
    }

    fun fetchbookByName(name: String):Book{
       return books.filter {
            it.name == name
        }[0]
    }

    fun updateQtyBorrowed(book: Book){
        books.filter {
            it.name == book.name
        }[0].apply{
            qty -= 1
        }
    }

    fun updateQtyReturned(book: Book){
        books.filter{
            it.name == book.name
        }[0].apply{
            qty += 1
        }
    }
}
class BookManagerImpl(private val databaseManager: DatabaseManager, val notificationManager: NotificationManager):BookManager{
    override fun isBookAvailable(book: Book): Boolean {
        return (databaseManager.fetchbookByName(book.name).qty>0)
    }

    override fun borrowBook(book: Book) {
        if(isBookAvailable(book))
            databaseManager.updateQtyBorrowed(book)
    }

    override fun returnBook(book: Book) {
        databaseManager.updateQtyReturned(book)
    }

    override fun getAllBooks(): MutableList<Book> {
        return databaseManager.getallBooks()
    }
}


fun main() {

    val bookManagerImpl = BookManagerImpl(DatabaseManager(),NotificationManagerImpl())
    bookManagerImpl.getAllBooks()
}

class NotificationManagerImpl : NotificationManager {
    override fun sendNotification() {
        TODO("Not yet implemented")
    }

}
