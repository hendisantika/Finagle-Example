package com.hendisantika.finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

/**
  * Created by hendisantika on 28/12/16.
  * https://twitter.github.io/finagle/guide/Quickstart.html
  * sbt 'run-main Server'
  * curl -D - localhost:8080
  */
object Server extends App{
  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] =
      Future.value(
        http.Response(req.version, http.Status.Ok)
      )
  }
  val server = Http.serve(":8080", service)
  Await.ready(server)

}
