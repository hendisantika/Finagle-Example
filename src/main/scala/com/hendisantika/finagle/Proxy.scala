package com.hendisantika.finagle

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Await

/**
  * Created by hendisantika on 28/12/16.
  * sbt 'run-main Proxy' & $ curl --dump-header - --header "Host: twitter.com" localhost:8080
  * HTTP/1.1 301 Moved Permanently
  * content-length: 0
  * date: Wed, 01 Jun 2016 21:26:57 GMT
  * location: https://twitter.com/
  */
object Proxy extends App{
  val client: Service[Request, Response] =
    Http.newService("twitter.com:80")

  val server = Http.serve(":8080", client)
  Await.ready(server)
}
