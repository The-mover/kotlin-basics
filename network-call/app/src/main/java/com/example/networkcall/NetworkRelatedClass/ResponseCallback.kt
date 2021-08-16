package com.example.networkcall.NetworkRelatedClass

interface ResponseCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Throwable)
}