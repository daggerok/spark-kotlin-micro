package daggerok

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import spark.*
import spark.Spark.*

var counter = 0
val mapper = jacksonObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

fun json(any: Any): String = mapper.writeValueAsString(any)

val spaHandler = fun(req: Request, _: Response) =
  """
    <h3>hi!</h3>
    <pre><code>counter: ${counter++}</pre></code>
    <div>
      <p>headers: <code>${json(req.headers())}</code></p>
    </div>
  """

fun main(args: Array<String>) {
  port(8080)
  path("/", { get("*", spaHandler) })
}
