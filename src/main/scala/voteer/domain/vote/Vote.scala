package voteer.domain.vote

case class Participant(name: String)

case class Vote(participant: Participant, pollId: String, choices: List[String])