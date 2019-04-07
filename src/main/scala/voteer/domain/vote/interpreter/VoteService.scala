package voteer.domain.vote.interpreter

import voteer.domain.poll.interpreter.OpenPoll
import voteer.domain.vote.interpreter.common._

import scala.util.{Success, Try}

trait VoteService extends voteer.domain.vote.VoteService[OpenPoll, Participant, Choices, Vote] {
  override def vote(poll: OpenPoll, participant: Participant, choices: Choices): Try[Vote] = Success(Vote(participant, poll.id, choices))
}

object VoteService extends VoteService
