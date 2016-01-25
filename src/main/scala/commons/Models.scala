package com.github.edgecaseberg.rssstalker.commons

import java.net.URL

case class Author(val name: String) 

case class Category(val name: String)

case class Article(
	val source: URL,
	val title: String,
	val publishedDate: Long,
	val description: String,
	val authors: List[Author],
	val categories: List[Category]
	)