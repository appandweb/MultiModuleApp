package com.appandweb.multimoduleapp.library.features.products


class GetProductsMockImpl : GetProducts {
    override fun getProducts(listener: GetProducts.Listener) {
        listener.onSuccess(
            listOf(
                MMProduct(
                    "d242b2d",
                    "Cat and mouse inc.",
                    "https://images.blinkist.com/images/books/5694b3802f6827000700002a/3_4/640.jpg",
                    4.99f
                ),
                MMProduct(
                    "eea5ee1",
                    "The Secret Life of Sleep",
                    "https://images.blinkist.com/images/books/56c1de12587c820007000063/3_4/640.jpg",
                    2.99f
                ),
                MMProduct(
                    "7e2401d",
                    "The Sleep Revolution",
                    "https://images.blinkist.com/images/books/5776159b86883200034f4744/3_4/640.jpg",
                    2.99f
                ),
                MMProduct(
                    "03779ee",
                    "Real Artists Don’t Starve",
                    "https://images.blinkist.com/images/books/599817dbb238e10006a125cb/3_4/640.jpg",
                    2.99f
                )
            )
        )
    }
}