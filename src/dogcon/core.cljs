(ns dogcon.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "Starting dogcon ...")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Dogcon"}))


(defn title []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "A console for dogbot!"]])

(reagent/render-component [title]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)