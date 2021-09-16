package by.ocheretny.weathertesttask.mappers

interface Mapper<F, T> {
    fun map(from: F?): T
}