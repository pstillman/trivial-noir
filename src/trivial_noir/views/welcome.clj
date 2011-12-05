(ns trivial-noir.views.welcome
  (:require [trivial-noir.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [trivial-noir.db.mongo :only [with-db-conn]])
  (:use somnium.congomongo))



(defpage "/frontpage" []
  (with-db-conn
    (let [text ((fetch-one :docs :where { :slug "zombie" }) :text)]
      (common/site-layout
       [:h1 "Front Page!"]
       [:p text]))))