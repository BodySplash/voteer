package voteer.domain.vote.interpreter

import voteer.domain.vote.interpreter.common._

object common {
  type Participant = String
  type Choices = List[String]
}


case class Vote(participant: Participant, pollId: String, choices: Choices)