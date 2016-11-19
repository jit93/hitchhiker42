
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
object drinker extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.BeerDB.DrinkerInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(drinkerInfo: models.BeerDB.DrinkerInfo):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.42*/("""

"""),_display_(/*3.2*/main("Drinker Information: " + drinkerInfo.name)/*3.50*/ {_display_(Seq[Any](format.raw/*3.52*/(""" """)))}/*3.54*/ {_display_(Seq[Any](format.raw/*3.56*/("""
  """),format.raw/*4.3*/("""<p>
    Address: """),_display_(/*5.15*/drinkerInfo/*5.26*/.address),format.raw/*5.34*/("""<br/>
    """),_display_(/*6.6*/drinkerInfo/*6.17*/.beersLiked.size),format.raw/*6.33*/("""
    """),_display_(/*7.6*/if(drinkerInfo.beersLiked.size > 1)/*7.41*/ {_display_(Seq[Any](format.raw/*7.43*/("""beers""")))}/*7.50*/else/*7.55*/{_display_(Seq[Any](format.raw/*7.56*/("""beer""")))}),format.raw/*7.61*/("""
    """),format.raw/*8.5*/("""liked:
    """),_display_(/*9.6*/for(i <- 0 until drinkerInfo.beersLiked.size) yield /*9.51*/ {_display_(Seq[Any](_display_(/*9.54*/if(i > 0)/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/(""",""")))}),format.raw/*9.67*/("""
      """),_display_(/*10.8*/drinkerInfo/*10.19*/.beersLiked(i))))}),format.raw/*10.34*/("""<br/>
    """),_display_(/*11.6*/drinkerInfo/*11.17*/.barsFrequented.size),format.raw/*11.37*/("""
    """),_display_(/*12.6*/if(drinkerInfo.barsFrequented.size > 1)/*12.45*/ {_display_(Seq[Any](format.raw/*12.47*/("""bars""")))}/*12.53*/else/*12.58*/{_display_(Seq[Any](format.raw/*12.59*/("""bar""")))}),format.raw/*12.63*/("""
    """),format.raw/*13.5*/("""frequented:
    """),_display_(/*14.6*/for(i <- 0 until drinkerInfo.barsFrequented.size) yield /*14.55*/ {_display_(Seq[Any](_display_(/*14.58*/if(i > 0)/*14.67*/ {_display_(Seq[Any](format.raw/*14.69*/(""",""")))}),format.raw/*14.71*/("""
      """),_display_(/*15.8*/drinkerInfo/*15.19*/.barsFrequented(i)),format.raw/*15.37*/("""
      """),format.raw/*16.7*/("""("""),_display_(/*16.9*/drinkerInfo/*16.20*/.timesFrequented(i)),format.raw/*16.39*/("""
       """),_display_(/*17.9*/if(drinkerInfo.timesFrequented(i) > 1)/*17.47*/ {_display_(Seq[Any](format.raw/*17.49*/("""times""")))}/*17.56*/else/*17.61*/{_display_(Seq[Any](format.raw/*17.62*/("""time""")))}),format.raw/*17.67*/("""
       """),format.raw/*18.8*/("""a week)""")))}),format.raw/*18.16*/("""<br/>
    <br/>
    <a href=""""),_display_(/*20.15*/routes/*20.21*/.Application.editDrinker(drinkerInfo.name)),format.raw/*20.63*/("""">Edit</a>
    this information or see
    <a href=""""),_display_(/*22.15*/routes/*22.21*/.Application.index()),format.raw/*22.41*/("""">all drinkers</a>.
  </p>
""")))}),format.raw/*24.2*/("""
"""))}
  }

  def render(drinkerInfo:models.BeerDB.DrinkerInfo): play.twirl.api.HtmlFormat.Appendable = apply(drinkerInfo)

  def f:((models.BeerDB.DrinkerInfo) => play.twirl.api.HtmlFormat.Appendable) = (drinkerInfo) => apply(drinkerInfo)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Nov 19 15:57:21 EST 2016
                  SOURCE: /opt/dbcourse/hitchhiker42/app/views/drinker.scala.html
                  HASH: a68a7e4c27ef67d2c22280d298cae0e1b4b61e3f
                  MATRIX: 744->1|872->41|900->44|956->92|995->94|1015->96|1054->98|1083->101|1127->119|1146->130|1174->138|1210->149|1229->160|1265->176|1296->182|1339->217|1378->219|1402->226|1414->231|1452->232|1487->237|1518->242|1555->254|1615->299|1654->302|1671->311|1710->313|1742->315|1776->323|1796->334|1835->349|1872->360|1892->371|1933->391|1965->397|2013->436|2053->438|2077->444|2090->449|2129->450|2164->454|2196->459|2239->476|2304->525|2344->528|2362->537|2402->539|2435->541|2469->549|2489->560|2528->578|2562->585|2590->587|2610->598|2650->617|2685->626|2732->664|2772->666|2797->673|2810->678|2849->679|2885->684|2920->692|2959->700|3016->730|3031->736|3094->778|3174->831|3189->837|3230->857|3288->885
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|35->7|36->8|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|41->13|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|48->20|48->20|48->20|50->22|50->22|50->22|52->24
                  -- GENERATED --
              */
          