
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object error extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Error")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/(""" """)))}/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
  """),format.raw/*4.3*/("""<p>"""),_display_(/*4.7*/message),format.raw/*4.14*/(""".</p>
  <p>Go back to <a href=""""),_display_(/*5.27*/routes/*5.33*/.Application.index()),format.raw/*5.53*/("""">all drinkers</a>.</p>
""")))}),format.raw/*6.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Nov 19 15:57:21 EST 2016
                  SOURCE: /opt/dbcourse/hitchhiker42/app/views/error.scala.html
                  HASH: 2ff5471c1b6b38d0b56a5fddd8d82fbbf0e7d1b7
                  MATRIX: 723->1|828->18|856->21|877->34|916->36|936->38|975->40|1004->43|1033->47|1060->54|1118->86|1132->92|1172->112|1226->137
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6
                  -- GENERATED --
              */
          