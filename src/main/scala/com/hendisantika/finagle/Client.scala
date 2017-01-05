package com.hendisantika.finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

/**
  * Created by hendisantika on 28/12/16.
  * sbt 'run-main Client'
  *
  * GET success: Response("HTTP/1.1 Status(200)")
  */
object Client extends App{
  val client: Service[http.Request, http.Response] = Http.newService("www.scala-lang.org:80")
  val request = http.Request(http.Method.Get, "/")
  request.host = "www.scala-lang.org"
  val response: Future[http.Response] = client(request)
  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)
  })
}
