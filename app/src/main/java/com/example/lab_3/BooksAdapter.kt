package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter(private val allBooks: List<Book>,
                   private val onItemClicked: (item: List<String>) -> Unit,
): RecyclerView.Adapter<BookViewHolder>() {

    private fun onViewHolderClicked(viewItemBook: View) {
        val bookProperties : List<String> = listOf(

            viewItemBook.findViewById<TextView>(R.id.Book_name).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.description).text.toString())
            /*viewItemBook.findViewById<TextView>(R.id.author).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.year).text.toString(),
            viewItemBook.findViewById<TextView>(R.id.rating).text.toString())*/
        onItemClicked(bookProperties)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BookViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view, this::onViewHolderClicked)
    }

    override fun getItemCount(): Int {
        return allBooks.size
    }

    override fun onBindViewHolder(
        holder: BookViewHolder, position: Int
    ) {
        holder.bind(allBooks[position])
    }
}


class BookViewHolder(itemView: View, private val onItemClicked: (View) -> Unit
): RecyclerView.ViewHolder(itemView) {

    private val nameView: TextView =
        itemView.findViewById(R.id.Book_name)
    private val authorView: TextView =
        itemView.findViewById(R.id.author)
    private val yearView: TextView =
        itemView.findViewById(R.id.year)
    private val ratingView: TextView =
        itemView.findViewById(R.id.rating)
    private val pictureView: ImageView =
        itemView.findViewById(R.id.Book_image)
    private val description: TextView =
        itemView.findViewById(R.id.description)

    init {
        itemView.setOnClickListener { onItemClicked(itemView) }
    }

    private val authorsNames: List<String> = arrayListOf<String>("Пушкин А.С.", "Островский А.Н",
        "Гончаров И.А.", "Тургенев И.С.", "Достоевский Ф.М.")

    private val booksNames: List<String> = arrayListOf<String>(
        "Зимнее утро", "Узник", "Евгений Онегин", "Медный всадник",
        "Гроза", "Бесприданница", "Снегурочка", "Свои люди - сочтёмся",
        "Обломов", "Обрыв", "Необыкновенная история", "Обыкновенная",
        "Отцы и дети", "Муму", "Записки охотника", "Первая любовь",
        "Преступление и наказание", "Белые ночи", "Бедные люди", "Идиот")

    private val booksYears: List<String> = arrayListOf<String>(
        "1829", "1822", "1833", "1833",
        "1859", "1878", "1873", "1849",
        "1847", "1869", "1824", "1844",
        "1860", "1852", "1852", "1860",
        "1865", "1848", "1844", "1867",)

    private val allDescriptions : List<String> = arrayListOf<String>(
        "В стихотворении «Зимнее утро» Пушкин описывает зимнее утро " +
                "с его холодом, тишиной и пустотой. Это утро становится символом " +
                "одиночества, отчуждения и разочарования. Герой стихотворения" +
                " ощущает себя отделенным от мира, его мысли и чувства замерзают," +
                " как зимний пейзаж за окном.\n" + "Тема «зимнего утра» в творчестве " +
                "Пушкина имеет глубокий символический смысл. Она отражает состояние " +
                "души героя, его внутренние переживания и эмоции.",
        "Стихотворение «Узник» было написано А. С. Пушкиным в 1822 году во время " +
                "его пребывания в ссылке.\n" +
                "\n" +
                "Тема стихотворения — борьба за свободу. Несчастный узник сидит " +
                "«за решёткой в темнице сырой» и наблюдает за орлом, который так же," +
                " как и он, больше всего ценит волю.\n" +
                "\n" +
                "Главная мысль «Узника» состоит в том, что человека никто и ничто" +
                " не может ограничить, если он хочет освободиться и борется за свободу.",
        "Роман в стихах русского поэта Александра Сергеевича Пушкина, " +
                "начат 9 мая 1823 года и закончен 5 октября 1831 года, одно " +
                "из самых значительных произведений русской словесности. " +
                "Повествование ведётся от имени безымянного автора, который, " +
                "впрочем, в первых же строфах называет Онегина «добрый мой приятель»." +
                " По известному определению В. Г. Белинского, Пушкин назвал " +
                "«Евгения Онегина» романом в стихах, поскольку в нём изображена " +
                "жизнь во всей её прозаической действительности. ",
        "Поэма А. С. Пушкина «Медный всадник» соединила в себе как историческую, " +
                "так и социальную проблематику. Это размышление автора о " +
                "Петре Великом как о реформаторе, собрание различных мнений и" +
                " оценок о его действиях. Это поэма – одно из его совершенных" +
                " сочинений, имеющих философский смысл.",
        "Описание 'Грозы'",
        "Описание 'Бесприданницы'",
        "Описание 'Снегурочки'",
        "Описание 'Свои люди - сочтёмся'",
        "Описание 'Обломова'",
        "Описание 'Обрыва'",
        "Описание 'Необыкновенной истории'",
        "Описание 'Обыкновенная'",
        "Описание 'Отцы и дети'",
        "Описание 'Муму'",
        "Описание 'Записки охотника'",
        "Описание 'Первая любовь'",
        "Описание 'Преступление и наказание'",
        "Описание 'Белые ночи'",
        "Описание 'Бедные люди'",
        "Описание 'Идиот'")

    fun bind(item: Book) {
        nameView.text = booksNames[adapterPosition]
        authorView.text = "Автор: " + authorsNames[adapterPosition/4]
        yearView.text = "Год создания: " + booksYears[adapterPosition]
        ratingView.text = "Рейтинг: " + (6..10).random().toString() + "/10"
        description.text = allDescriptions[adapterPosition]
    }
}
