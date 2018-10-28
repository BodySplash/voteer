package voteer.domain.vote

import voteer.domain.poll.OpenPoll

trait VoteServices {
  def vote(poll: OpenPoll, participantName: String, choices: List[String]) {

  }
}

object VoteServices extends VoteServices
