package com.yonder.breakingbadcompose.domain.mapper.base

interface Mapper <in T , out R> {
    fun map(input : T) : R
}