package voteer.domain.poll.interpreter

import voteer.domain.poll.interpreter.common._

object common {
  type PollId = String
  type PollKey = String
  type Choice = String
}

sealed trait Poll {
  def id: PollId

  def choices: List[Choice]

  def adminKey: PollKey

  def options: PollOptions

}

final case class PollOptions(withComments: Boolean)

final case class PendingPoll private(id: PollId, adminKey: PollKey, choices: List[Choice] = List(), options: PollOptions = PollOptions(false)) extends Poll

final case class OpenPoll private(id: PollId, adminKey: PollKey, choices: List[Choice], options: PollOptions) extends Poll

final case class ClosePoll private(id: PollId, adminKey: PollKey, choices: List[Choice], options: PollOptions) extends Poll
