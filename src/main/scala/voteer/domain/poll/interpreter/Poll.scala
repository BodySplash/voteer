package voteer.domain.poll.interpreter

import voteer.domain.poll.interpreter.common._

object common {
  type PollId = String
  type PollKey = String
  type Choice = String
}

trait Poll {
  def id: PollId

  def choices: List[Choice]

  def adminKey: PollKey

  def options: PollOptions

}

case class PollOptions(withComments: Boolean)

case class PendingPoll(id: PollId, adminKey: PollKey, choices: List[Choice] = List(), options: PollOptions = PollOptions(false)) extends Poll

case class OpenPoll(id: PollId, adminKey: PollKey, choices: List[Choice], options: PollOptions) extends Poll

case class ClosePoll(id: PollId, adminKey: PollKey, choices: List[Choice], options: PollOptions) extends Poll
