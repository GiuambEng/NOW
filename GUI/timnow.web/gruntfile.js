module.exports = function(grunt) {
    
    require('load-grunt-tasks')(grunt);
    
	// Configurable paths for the application
	var appConfig = {
		dist: 'dist',
		tmp: '.tmp',
		bowerdir: grunt.file.readJSON('.bowerrc').directory || 'bower_components',
		webappdir: 'src/main/webapp/',
		appdir: 'src/main/webapp/app/',
	};
	
    grunt.initConfig({
    	
        pkg: grunt.file.readJSON('package.json'),
        
        appConfig: appConfig,
     
        clean: {
            options: {
                force: true
            },
            build: [
                '<%= appConfig.dist %>', 
                '<%= appConfig.tmp %>',
            ],
            app: [
                '<%= appConfig.dist %>/app/**/*.js', 
                '<%= appConfig.dist %>/app.js',
                '<%= appConfig.dist %>/app.routes.js',
            ],
        },
                
        copy: {
            app: {
                expand: true,
                cwd: '<%= appConfig.webappdir %>',
                src: ['app/**/*.html', 'app/**/*.js', '*.html', '*.js'],
                dest: '<%= appConfig.dist %>/'
            },
            
            assets: {
                expand: true,
                cwd: '<%= appConfig.webappdir %>',
                src: ['assets/**', 'img/**'],
                dest: '<%= appConfig.dist %>/'
            },
            
            fonts: {
                expand: true,
                cwd: '<%= appConfig.bowerdir %>/bootstrap/dist/fonts/',
                src: ['**'],
                dest: '<%= appConfig.dist %>/vendor/fonts/'
            },
            
        },
        
        jshint: {
            options: {
                force: true
            },
            all: [
                '<%= appConfig.webappdir %>/*.js',
                '<%= appConfig.appdir %>/**/*.js',
            ]
        },
        
        wiredep: {
            task: {
                directory: '<%= appConfig.webappdir %>/bower_components',
                bowerJson: require('./bower.json'),
                src: [
                      '<%= appConfig.dist %>/index.html'
                ],
                exclude: ['jquery']
            }
        },
        
		uglify : {
			options : {
			    mangle: false
			}
		},
				
		useminPrepare: {
			html: ['<%= appConfig.dist %>/**/*.html'],
			options: {
				dest: '<%= appConfig.dist %>',
			}
		},
		
		usemin: {
			html: ['<%= appConfig.dist %>/**/*.html'],
			options: {
				dest: '<%= appConfig.dist %>',
				assetsDirs: '<%= appConfig.dist %>',
			}
		},
		
		// Renames files for browser caching purposes
		filerev: {
			dist: {
				src: [
					'<%= appConfig.dist %>/app/*.js',
					'<%= appConfig.dist %>/assets/**/*.{png,jpg,jpeg,gif,webp,svg}',
					'<%= appConfig.dist %>/assets/**/*.css',
					'<%= appConfig.dist %>/img/*.{png,jpg,jpeg,gif,webp,svg}',
					'<%= appConfig.dist %>/vendor/css/*.css',
					'<%= appConfig.dist %>/vendor/js/*.js',
				]
			}
		},

		// TODO probabilmente e' possibile effettuare le sostituzioni solo
		// utilizzando usemin ma al momento non funziona.
		filerev_replace : {
			options: {
				assets_root: '<%= appConfig.dist %>'
			},
			compiled_assets: {
				src : [
				    '<%= appConfig.dist %>/**/*.{css,js}',
				]
			},
			views: {
				options : {
					views_root : '<%= appConfig.dist %>/'
				},
				src : '<%= appConfig.dist %>/**/*.html',
			},
		},
		
    });

    
    grunt.registerTask('build', [
        'clean:build',  
        'jshint:all',
        'copy:app', 
        'copy:assets', 
        'copy:fonts', 
        'wiredep',
        'useminPrepare', 
        'concat:generated',
        'clean:app',
        'uglify:generated',
        'cssmin:generated',
        'filerev',
        'filerev_replace',
        'usemin',
    ]);

};
