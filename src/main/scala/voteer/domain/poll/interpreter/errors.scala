package voteer.domain.poll.interpreter

import voteer.domain.ErrorCode

case object DuplicateChoice extends ErrorCode
case object EmptyPoll extends ErrorCode