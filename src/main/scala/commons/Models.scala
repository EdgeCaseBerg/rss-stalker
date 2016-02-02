package com.github.edgecaseberg.rssstalker.commons

import java.net.URL

trait Entity {
	val id : Int 
}

case class Author(val name: String) extends Entity

case class Category(val name: String) extends Entity

case class Article(
	val source: URL,
	val title: String,
	val publishedDate: Long,
	val description: String,
	val authors: List[Author],
	val categories: List[Category]
	)
