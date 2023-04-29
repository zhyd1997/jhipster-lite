import { defineComponent } from 'vue';
import { IconVue } from '@/common/primary/icon';

export default defineComponent({
  name: 'Header',

  components: {
    IconVue,
  },

  setup() {
    const selectorPrefix = 'header';

    return {
      selectorPrefix,
    };
  },

  data() {
    return {
      userTheme: 'light-theme',
    };
  },
  mounted() {
    const initUserTheme = (this.getTheme() as 'light-theme' | 'dark-theme') || this.getMediaPreference();
    this.setTheme(initUserTheme);
  },

  methods: {
    toggleTheme() {
      const activeTheme = localStorage.getItem('user-theme');
      if (activeTheme === 'light-theme') {
        this.setTheme('dark-theme');
      } else {
        this.setTheme('light-theme');
      }
    },

    getTheme() {
      return localStorage.getItem('user-theme');
    },

    setTheme(theme: 'light-theme' | 'dark-theme') {
      localStorage.setItem('user-theme', theme);
      this.userTheme = theme;
      document.documentElement.className = theme;
    },

    getMediaPreference() {
      const hasDarkPreference: MediaQueryList['matches'] = window.matchMedia('(prefers-color-scheme: dark)').matches;
      if (hasDarkPreference) {
        return 'dark-theme';
      } else {
        return 'light-theme';
      }
    },
  },
});
