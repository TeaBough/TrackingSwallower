package models

case class TrackingData(cookie_id: String, email: String, session_id: String, referer: String, timestamp: String, event: String)

object JsonFormats {

  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val userFormat = Json.format[TrackingData]
}