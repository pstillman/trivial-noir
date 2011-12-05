(ns trivial-noir.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
  (html5
   [:head [:title "trivial-noir"] (include-css "/css/reset.css")]
   [:body [:div#wrapper content]]))

(defpartial site-layout [& content]
  (html5
   [:head [:title "Trivial Noir"]]
   [:body [:div#wrapper content]]))