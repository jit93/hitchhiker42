// @SOURCE:/home/catriona316/hitch/conf/routes
// @HASH:b2deec6d9df1c7345c170ef07e65b7a8ea4777eb
// @DATE:Sun Nov 06 16:26:48 EST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
package controllers {

// @LINE:11
class ReverseAssets {


// @LINE:11
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:5
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def editDrinker(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "edit-drinker/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

// @LINE:8
def updateDrinker(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "update-drinker")
}
                        

// @LINE:6
def viewDrinker(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "drinker/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
class ReverseAssets {


// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:5
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def editDrinker : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editDrinker",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit-drinker/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:8
def updateDrinker : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.updateDrinker",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "update-drinker"})
      }
   """
)
                        

// @LINE:6
def viewDrinker : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.viewDrinker",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drinker/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.ref {


// @LINE:11
class ReverseAssets {


// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReverseApplication {


// @LINE:5
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:7
def editDrinker(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editDrinker(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "editDrinker", Seq(classOf[String]), "GET", """""", _prefix + """edit-drinker/$name<[^/]+>""")
)
                      

// @LINE:8
def updateDrinker(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.updateDrinker(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateDrinker", Seq(), "POST", """""", _prefix + """update-drinker""")
)
                      

// @LINE:6
def viewDrinker(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.viewDrinker(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viewDrinker", Seq(classOf[String]), "GET", """""", _prefix + """drinker/$name<[^/]+>""")
)
                      

}
                          
}
        
    