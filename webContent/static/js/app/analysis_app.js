var app = app || {};

(function ($) {
    'use strict';

    // Rank Model
    // ----------
    app.Rank = Backbone.Model.extend({

        urlRoot: "/api/rank/",

        defaults: function () {
            return {
                id: null,
                text: "Lorem ipsum dolor sit amet",
                value: 69
            };
        }

    });

    var Ranking = Backbone.Collection.extend({
        model: app.Rank,

        baseUrl: '/api/rank/'
    });

    // Create our global collection of **Ranking**.
    app.Ranking = new Ranking();

    // Analysis View
    // --------------
    app.RankItemView = Backbone.View.extend({
 
        tagName: 'li',

        template: _.template("<%= text %> <span class='label label-success'><%= value %></span>"),

        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },
    });

    // Analysis View
    // --------------
    app.AnalysisView = Backbone.View.extend({
 
        el: "#analysis-content",

        initialize: function () {
            this.listenTo(app.Ranking, 'add', this.addOne);
            this.listenTo(app.Ranking, 'reset', this.addAll);
            //this.listenTo(app.Ranking, 'all', this.render);

            //app.Ranking.fetch();
        },

        addOne: function (rank) {
            var view = new app.RankItemView({
                model: rank
            });
            this.$(".stats ul.rank").append(view.render().el);
        },

        addAll: function () {
            app.Ranking.each(this.addOne, this);
        }
    });
})(jQuery);