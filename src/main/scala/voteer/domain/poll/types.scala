package voteer.domain.poll

trait Poll {

  def id: String

  def choices: List[String]

  def adminKey: String

  def options: PollOptions

}

case class PollOptions(withComments: Boolean)

case class PendingPoll(id: String, adminKey: String, choices: List[String], options: PollOptions) extends Poll

case class OpenPoll(id: String, adminKey: String, choices: List[String], options: PollOptions) extends Poll

case class ClosePoll(id: String, adminKey: String, choices: List[String], options: PollOptions) extends Poll
