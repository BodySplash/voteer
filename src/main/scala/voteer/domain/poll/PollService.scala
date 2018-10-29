package voteer.domain.poll

import scala.util.Try

trait PollService[PollId, PollKey, OpenPoll, PendingPoll, ClosePoll, Choice, PollOptions] {

  def create(id: PollId, key: PollKey, name: String): Try[PendingPoll]

  def addChoice(poll: PendingPoll, choice: Choice): Try[PendingPoll]

  def open(poll: PendingPoll): Try[OpenPoll]

  def close(poll: OpenPoll): Try[ClosePoll]
}

