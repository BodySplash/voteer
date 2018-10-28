package voteer.domain.poll

import voteer.domain.{BusinessError, IdGenerator}

import scala.util.{Failure, Success, Try}

trait PollServices {
  def create(generator: IdGenerator): PendingPoll = {
    PendingPoll(generator.next(), generator.next(), List(), PollOptions(false))
  }

  def addChoice(poll: PendingPoll, choice: String): Try[PendingPoll] = {
    if (poll.choices.contains(choice)) {
      return Failure(new BusinessError(DuplicateChoice))
    }
    val newChoices: List[String] = poll.choices.::(choice)
    Success(poll.copy(choices = newChoices))
  }

  def open(poll: PendingPoll): Try[OpenPoll] = {
    if (poll.choices.isEmpty) {
      return Failure(new BusinessError(EmptyPoll))
    }
    Success(OpenPoll(poll.id, poll.adminKey, poll.choices, poll.options))
  }
}

object PollServices extends PollServices
