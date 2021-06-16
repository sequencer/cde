import mill._
import scalalib._
import scalafmt._
import publish._
// Use VCS Version
import $ivy.`de.tototec::de.tobiasroeser.mill.vcs.version_mill0.9:0.1.1`
import de.tobiasroeser.mill.vcs.version.VcsVersion

object cde extends cde

class cde extends ScalaModule with ScalafmtModule with PublishModule {
  def scalaVersion = "2.12.13"

  def publishVersion = VcsVersion.vcsState().format()

  def pomSettings = PomSettings(
    description = artifactName(),
    organization = "me.sequncer",
    url = "https://www.github.com/sequencer/cde",
    licenses = Seq(License.`Apache-2.0`),
    versionControl = VersionControl.github("sequencer", "cde"),
    developers = Seq(
      Developer("terpstra", "Wesley W. Terpstra", "https://github.com/terpstra"),
      Developer("sequencer", "Jiuyang Liu", "https://jiuyang.me"),
    )
  )
}
