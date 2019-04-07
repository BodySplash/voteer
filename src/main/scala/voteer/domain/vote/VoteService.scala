package voteer.domain.vote

import scala.util.Try

trait VoteService[Poll, Participant, Choices, Vote] {

  def vote(poll: Poll, participant: Participant, choices: Choices): Try[Vote]

}
