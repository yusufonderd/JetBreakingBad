package com.yonder.breakingbadcompose.domain.mapper

interface Mapper <in T , out R> {
    fun map(input : T) : R
}