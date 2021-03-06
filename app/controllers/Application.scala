package controllers

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc._
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection

import scala.concurrent.Future

object Application extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("data")

  import models.JsonFormats._
  import models._

  def create = Action.async(parse.json) {
    request =>
      request.body.validate[TrackingData].map {
        data =>
          collection.insert(data).map {
            lastError =>
              Created(s"Tracking data added")
          }
      }.getOrElse(Future.successful(BadRequest("invalid json")))
  }
}
