(ns dogcon.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent-material-ui.core :as ui]))

(enable-console-print!)

(println "Starting dogcon ...")

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Dogcon"}))

;; helpers
(def el reagent/as-element)
(defn color [nme] (aget ui/colors nme))

;; create new theme based on MaterialUI dark theme
(defonce theme-defaults {:muiTheme(ui/getMuiTheme(-> ui/darkBaseTheme
                                                     (js->clj :keywordize-keys true)
                                                     (update :palatte merge {:primary1Color (color "amber500")
                                                                             :primary2Color(color "amber700")})
                                                     clj->js))}
 )

(defn nav []
  [:div
   [ui/AppBar {:title "dogcon"}]])

(defn title []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "A console for dogbot!"]])

(defn page []
  [ui/MuiThemeProvider theme-defaults
   [:div
    [nav]
    [title]]])

(reagent/render-component [page]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
