package voteer.domain

trait IdGenerator {
  def next(): String
}
