import { ThemeButtonVue } from '@/common/primary/theme-button';
import { shallowMount } from '@vue/test-utils';
import { describe, expect, it } from 'vitest';

describe('ThemeButton', () => {
  it('Should exist', () => {
    const wrapper = shallowMount(ThemeButtonVue);

    expect(wrapper.exists()).toBe(true);
  });

  // TODO theme switch fn test.
});
