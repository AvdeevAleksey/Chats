interface CrudService<A> {

    fun add(entity: A): Int
    fun delete(id: Int)
    fun edit(entity: A)
    fun get(): List<A>
}