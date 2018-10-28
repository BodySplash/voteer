package voteer.domain

trait ErrorCode

case class BusinessError(error: ErrorCode) extends RuntimeException(error.toString.toUpperCase)
