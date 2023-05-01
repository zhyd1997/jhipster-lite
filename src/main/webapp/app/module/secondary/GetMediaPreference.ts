export type ThemePreference = 'light-theme' | 'dark-theme';

export const getMediaPreference = (): ThemePreference => {
  if (typeof window !== 'undefined' && window.matchMedia) {
    return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark-theme' : 'light-theme';
  }
  return 'light-theme';
};
