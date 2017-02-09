package repro

import io.circe.{Decoder, ObjectEncoder}
import io.circe.generic.semiauto._

/**
  * Created by erik on 2/9/17.
  */
case class Model(id: Int) 

object Model {
  implicit val modelDecoder: Decoder[Model] = deriveDecoder[Model]
  implicit val modelEncoder: ObjectEncoder[Model] = deriveEncoder[Model]
}
