package voteer.domain
package poll
package interpreter

import voteer.domain.poll.interpreter.common._

import scala.util.{Failure, Success, Try}


object PollServices extends PollService[PollId, PollKey, OpenPoll, PendingPoll, ClosePoll, Choice, PollOptions] {
  override def create(id: PollId, key: PollKey, name: String): Try[PendingPoll] = {
    Success(PendingPoll(id, key))
  }

  override def addChoice(poll: PendingPoll, choice: Choice): Try[PendingPoll] = {
    if (poll.choices.contains(choice)) {
      Failure(new BusinessError(DuplicateChoice))
    } else {
      Success(poll.copy(choices = choice :: poll.choices))
    }
  }

  override def open(poll: PendingPoll): Try[OpenPoll] = {
    if (poll.choices.isEmpty) {
      Failure(new BusinessError(EmptyPoll))
    } else {
      Success(OpenPoll(poll.id, poll.adminKey, poll.choices, poll.options))
    }
  }

  override def close(poll: OpenPoll): Try[ClosePoll] = ???
}