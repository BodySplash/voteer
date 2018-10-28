package voteer.domain.poll

import java.util.UUID

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

import scala.util.Success

@RunWith(classOf[JUnitRunner])
class PollServicesTest extends FunSpec with Matchers {

  describe("About poll creation") {

    it("creates poll with id") {
      val generator: Iterator[String] = List("test", "test2").iterator

      val poll = PollServices.create(() => generator.next())

      poll.id shouldEqual "test"
      poll.adminKey shouldEqual "test2"
    }

    it("creates poll with default options") {
      val poll = PollServices.create(() => "id")

      poll.options shouldEqual PollOptions(false)
    }

  }

  describe("About choices") {
    it("adds choice") {
      val poll: PendingPoll = aPoll()

      val newPoll = PollServices.addChoice(poll, "first")

      newPoll.isSuccess shouldBe true
      newPoll.get.choices shouldBe List("first")
    }

    it("rejects duplicated choice") {
      val poll = aPollWithChoice("first")

      val result = PollServices.addChoice(poll, "first")

      result.isFailure shouldBe true
    }
  }

  describe("About opening poll") {
    it("creates OpenPoll") {
      val pendingPoll = aPollWithChoice("test")

      val triedPoll = PollServices.open(pendingPoll)

      triedPoll shouldBe Success(OpenPoll(pendingPoll.id, pendingPoll.adminKey, pendingPoll.choices, pendingPoll.options))
    }

    it("doesn't open empty poll") {
      val poll = aPoll()

      val triedPoll = PollServices.open(poll)

      triedPoll.isFailure shouldBe true
    }
  }


  def aPollWithChoice(c: String) = withChoice(aPoll(), c)


  private def withChoice(p: PendingPoll, c: String) = PollServices.addChoice(p, c).get

  private def aPoll = () =>
    PollServices.create(() => UUID.randomUUID().toString)
}
